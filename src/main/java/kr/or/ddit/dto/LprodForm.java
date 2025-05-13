package kr.or.ddit.dto;

public class LprodForm {

    private int lprodId;
    private String lprodGu;
    private String lprodNm;

    public LprodForm() {
    }

    public int getLprodId() {
        return lprodId;
    }

    public void setLprodId(int lprodId) {
        this.lprodId = lprodId;
    }

    public String getLprodGu() {
        return lprodGu;
    }

    public void setLprodGu(String lprodGu) {
        this.lprodGu = lprodGu;
    }

    public String getLprodNm() {
        return lprodNm;
    }

    public void setLprodName(String lprodNm) {
        this.lprodNm = lprodNm;
    }

    @Override
    public String toString() {
        return "LprodForm{" +
                "lprodId=" + lprodId +
                ", lprodGu='" + lprodGu + '\'' +
                ", lprodNm='" + lprodNm + '\'' +
                '}';
    }
}
