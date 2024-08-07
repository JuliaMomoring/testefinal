package dell2;

public class Time {
    private String nome;
    private String gritoGuerra;
    private int anoFundacao;
    private int blots;
    private int plifs;
    private int advrunghs;

    public Time(String nome, String gritoGuerra, int anoFundacao) {
        this.nome = nome;
        this.gritoGuerra = gritoGuerra;
        this.anoFundacao = anoFundacao;
        this.blots = 0;       // Inicializa os valores
        this.plifs = 0;
        this.advrunghs = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGritoGuerra() {
        return gritoGuerra;
    }

    public void setGritoGuerra(String gritoGuerra) {
        this.gritoGuerra = gritoGuerra;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public int getBlots() {
        return blots;
    }

    public void adicionarBlots(int valor) {
        this.blots += valor;
    }

    public int getPlifs() {
        return plifs;
    }

    public void adicionarPlifs(int valor) {
        this.plifs += valor;
    }

    public int getAdvrunghs() {
        return advrunghs;
    }

    public void removerAdvrunghs(int valor) {
        this.advrunghs -= valor;
    }

    public int getPontuacaoTotal() {
        
        return (blots ) + (plifs ) - (advrunghs );
    }

	
}
