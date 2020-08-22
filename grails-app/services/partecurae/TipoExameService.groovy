package partecurae

import grails.gorm.services.Service

@Service(TipoExame)
interface TipoExameService {

    TipoExame get(Serializable id)

    List<TipoExame> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoExame save(TipoExame tipoExame)

}