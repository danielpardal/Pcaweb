package partecurae

import grails.gorm.services.Service

@Service(Veterinario)
interface VeterinarioService {

    Veterinario get(Serializable id)

    List<Veterinario> list(Map args)

    Long count()

    void delete(Serializable id)

    Veterinario save(Veterinario veterinario)

}