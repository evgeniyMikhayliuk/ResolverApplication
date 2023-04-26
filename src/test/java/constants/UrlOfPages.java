package constants;

public class UrlOfPages {

    private String basePage;

    public void setBasePage(String basePage){
        this.basePage = basePage;
    }

    public String getBasePage(){
        return basePage;
    }

    public String homePage(){
        String page = "/QE-index.html";
        return basePage + page;
    }



}