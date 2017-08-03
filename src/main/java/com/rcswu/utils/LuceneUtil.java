package com.rcswu.utils;

import com.rcswu.domain.Article;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class LuceneUtil {
    private static Directory directory;
    private static Analyzer analyzer;
    static{
        try {
            directory= FSDirectory.open(Paths.get("../indexDir"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        analyzer=new IKAnalyzer();
    }
    public static List<Article> search(String queryCondition) throws ParseException, IOException, java.text.ParseException, InvalidTokenOffsetsException {
        List<Article> articles=new ArrayList<>();
        BooleanQuery.Builder builder=new BooleanQuery.Builder();
        QueryParser titleQueryParser=new QueryParser("title",analyzer);
        Query titleQuery=titleQueryParser.parse(queryCondition);
        QueryParser summaryQueryParser=new QueryParser("summary",analyzer);
        Query summaryQuery=summaryQueryParser.parse(queryCondition);
        QueryParser tagQueryParser=new QueryParser("tag",analyzer);
        Query tagQuery=tagQueryParser.parse(queryCondition);
        builder.add(titleQuery, BooleanClause.Occur.SHOULD);
        builder.add(summaryQuery, BooleanClause.Occur.SHOULD);
        builder.add(tagQuery, BooleanClause.Occur.SHOULD);
        IndexReader indexReader= DirectoryReader.open(directory);
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        TopDocs topDocs=indexSearcher.search(builder.build(),100);
        Integer count=topDocs.totalHits;
        ScoreDoc[] scoreDocs=topDocs.scoreDocs;
        Sort sort=new Sort(new SortField("date",SortField.Type.STRING));
        Analyzer analyzer=new IKAnalyzer();
        SimpleHTMLFormatter simpleHTMLFormatter=new SimpleHTMLFormatter(
                "<font color='red'>","</font>"
        );
        Highlighter highlighter=new Highlighter(simpleHTMLFormatter,
                new QueryScorer(builder.build()));
        highlighter.setTextFragmenter(new SimpleFragmenter(150));
        for(int i=0;i<scoreDocs.length;i++){
            ScoreDoc scoreDoc=scoreDocs[i];
            int docId = scoreDoc.doc;
            // System.out.println("得分是："+scoreDoc.score+"，内部编号是："+docId);
            // 根据内部编号取出真正的Document数据
            Document doc = indexSearcher.doc(docId);
            // 将document转化为Article
            Article article = new Article();
            article.setArticleId(doc.get("id"));
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(doc
                    .get("date"));
            article.setArticleDate(date);

            TokenStream titleStream = analyzer.tokenStream("title",
                    new StringReader(doc.get("title")));
            String titleString = highlighter.getBestFragment(titleStream,
                    doc.get("title"));

            TokenStream tagStream = analyzer.tokenStream("tag",
                    new StringReader(doc.get("tag")));
            String tagString = highlighter.getBestFragment(tagStream,
                    doc.get("tag"));

            TokenStream summaryStream = analyzer.tokenStream("summary",
                    new StringReader(doc.get("summary")));
            String summaryString = highlighter.getBestFragment(summaryStream,
                    doc.get("summary"));

            article.setArticleTitle(titleString == null ? doc.get("title")
                    : titleString);
            article.setTag(tagString == null ? doc.get("tag") : tagString);
            article.setArticleSummary(summaryString == null ? doc
                    .get("summary") : summaryString);
            articles.add(article);
        }
        return articles;
    }
    public static void add(Article article) throws IOException {
        IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
        Document doc=new Document();
        doc.add(new TextField("id",article.getArticleId().toString(), Field.Store.YES));
        doc.add(new TextField("title",article.getArticleTitle(), Field.Store.YES));
        doc.add(new TextField("tag",article.getTag(), Field.Store.YES));
        doc.add(new TextField("summary",article.getArticleSummary(), Field.Store.YES));
        String d=(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(article.getArticleDate());
        doc.add(new TextField("date",d, Field.Store.YES));
        IndexWriter indexWriter=new IndexWriter(directory,iwc);
        indexWriter.addDocument(doc);
        indexWriter.close();
    }
    public static void update(Article article) throws IOException {
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        Document doc = new Document();

        doc.add(new TextField("id", article.getArticleId().toString(),
                Field.Store.YES));

        doc.add(new TextField("title", article.getArticleTitle(), Field.Store.YES));

        doc.add(new TextField("tag", article.getTag(), Field.Store.YES));

        doc.add(new TextField("summary", article.getArticleSummary(), Field.Store.YES));

        String d = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(article
                .getArticleDate());
        doc.add(new TextField("date", d, Field.Store.YES));

        Term term = new Term("id", article.getArticleId());

        IndexWriter indexWriter = new IndexWriter(directory, iwc);
        indexWriter.updateDocument(term, doc);

        indexWriter.close(); // 释放资源
    }
    public static void delete(String articleId) throws IOException {
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        Term term = new Term("id", articleId);

        IndexWriter indexWriter = new IndexWriter(directory, iwc);
        indexWriter.deleteDocuments(term);

        indexWriter.close(); // 释放资源
    }
    public static void deleteAll() throws IOException {
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, iwc);
        indexWriter.deleteAll();
        indexWriter.close(); // 释放资源
    }
}
