package dk.bringlarsen.dbtu.rating;

class DBTURatinglisterPrintPageLinkBuilder {

    private DBTURatingServiceProperties properties;

    private String seasonId;
    private String pageNo = "0";

    public static DBTURatinglisterPrintPageLinkBuilder create(DBTURatingServiceProperties properties) {
        return new DBTURatinglisterPrintPageLinkBuilder(properties);
    }

    private DBTURatinglisterPrintPageLinkBuilder(DBTURatingServiceProperties properties) {
        this.properties = properties;
    }

    public String build() {
        return String.format(properties.getDBTURatingPrintPageURL(), seasonId, pageNo);
    }

    public DBTURatinglisterPrintPageLinkBuilder setSeasonId(String seasonId) {
        this.seasonId = seasonId;
        return this;
    }


    public DBTURatinglisterPrintPageLinkBuilder setPageNo(String pageNo) {
        this.pageNo = pageNo;
        return this;
    }
}