package partecurae

class Exame {

    String nome
    String animal
    String raca
    Integer idade
    String sexo
    String especie
    String proprietario
    Date dataEntrada
    Date dataResultado
    TipoExame tipoExame1
    String resultadoExame1
    TipoExame tipoExame2
    String resultadoExame2
    Material material
    Veterinario veterinario
    User responsavelPartecurae

    static constraints = {
        raca(nullable:true)
        idade(nullable:true)
        sexo(nullable:true)
        especie(nullable:true)
        proprietario(nullable:true)
        dataResultado(nullable:true)
        tipoExame1(nullable:true)
        resultadoExame1(nullable:true)
        tipoExame2(nullable:true)
        resultadoExame2(nullable:true)
        material(nullable:true)
        veterinario(nullable:true)
    }
}
