package comSpider.$5_JsonParse;

/*
    Excel模板类, 定义字段模板
 */

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelTemplateClass {
    @ExcelProperty(value = "电影序号", index = 0)
    private Integer rank;
    @ExcelProperty(value = "电影标题", index = 1)
    private String title;
    @ExcelProperty(value="电影类型", index = 2)
    private String types;
    @ExcelProperty(value="电影详情链接", index = 3)
    private String url;
    @ExcelProperty(value="上映地区", index = 4)
    private String regions;
    @ExcelProperty(value="上映时间", index = 5)
    private String releaseDate;
    @ExcelProperty(value="影片评分", index = 6)
    private Float score;
    @ExcelProperty(value="主演人员", index = 7)
    private String actors;

    public ExcelTemplateClass() {
    }

    public ExcelTemplateClass(Integer rank, String title, String types, String url, String regions, String releaseDate, Float score, String actors) {
        this.rank = rank;
        this.title = title;
        this.types = types;
        this.url = url;
        this.regions = regions;
        this.releaseDate = releaseDate;
        this.score = score;
        this.actors = actors;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "ExcelTemplateClass{" +
                "rank=" + rank +
                ", title='" + title + '\'' +
                ", types='" + types + '\'' +
                ", url='" + url + '\'' +
                ", regions='" + regions + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", score=" + score +
                ", actors=" + actors +
                '}';
    }
}
