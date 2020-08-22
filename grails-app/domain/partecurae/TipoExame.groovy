package partecurae

class TipoExame {

    String descricao
    String unidade
    String tecnica

    static constraints = {
        unidade(nullable:true)
        tecnica(nullable:true)
    }

    public String toString() {
        return "${descricao}"
    }
}
