package com.dzmitrykavalioum.rsstut.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/*<item>
		<title>Носкевич: Уголовное дело Тихановского до конца месяца будет передано прокурору для направления в суд</title>
		<link>https://news.tut.by/economics/721251.html?utm_campaign=news-feed&#x26;utm_medium=rss&#x26;utm_source=rss-news</link>
		<description>&#x3C;img src="https://img.tyt.by/thumbnails/n/regiony/07/6/tihanovski_20200520_kom_tutby_phs_4945.jpg" width="72" height="48" alt="Фото: Сергей Комков, TUT.BY" border="0" align="left" hspace="5" /&#x3E;Расследование по «делу Тихановского» близится к завершению и скоро будет передано прокурору для дальнейшего направления в суд, сообщил глава СК.&#x3C;br clear="all" /&#x3E;</description>
		<atom:author>
			<atom:name>TUT.BY</atom:name>
			<atom:uri>https://news.tut.by/author/490~613.html</atom:uri>
		</atom:author>
		<category domain="https://news.tut.by/economics/">Деньги и власть</category>
		<enclosure url="https://img.tyt.by/n/regiony/07/6/tihanovski_20200520_kom_tutby_phs_4945.jpg" type="image/jpeg" length="754188" />
		<guid isPermaLink="true">https://news.tut.by/economics/721251.html?utm_campaign=news-feed&#x26;utm_medium=rss&#x26;utm_source=rss-news</guid>
		<pubDate>Thu, 04 Mar 2021 12:45:00 +0300</pubDate>
		<media:content url="https://img.tyt.by/n/regiony/07/6/tihanovski_20200520_kom_tutby_phs_4945.jpg" type="image/jpeg" medium="image" height="801" width="1200" fileSize="754188" />
	</item>
* */

@Root (name = "item", strict = false)
public class Article1 {

    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;

    @Element (name = "pubDate")
    private String pubDate;

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
