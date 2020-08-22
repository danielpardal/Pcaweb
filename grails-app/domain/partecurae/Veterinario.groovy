package partecurae

class Veterinario {

    String nome
    String cpf
    String cnpj
    String endereco
    String cidade
    String uf
    String cep
    String telefone
    String razaoSocial
    User usuario

    static constraints = {
        cpf(nullable:true)
        cnpj(nullable:true)
        endereco(nullable:true)
        cidade(nullable:true)
        uf(nullable:true)
        cep(nullable:true)
        telefone(nullable:true)
        razaoSocial(nullable:true)
        usuario(nullable:true)
    }

    public String toString() {
        return "${nome}"
    }
}
