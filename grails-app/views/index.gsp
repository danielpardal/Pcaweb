<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Bem Vindo ao Sistema de Laudos Partecurae</title>
</head>
<body>
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Menu <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <li><a href=${c.logicalPropertyName}>${c.name}</a></li>
                </g:each>
            </ul>
        </li>        
    </content>

    <div id="content" role="main" padding="50">
            <br/>
            <p align="left">&nbsp;&nbsp;&nbsp;Bem-Vindo ao Sistema de Laudos ParteCurae</p>
            <br/>
            <p align="left">
                &nbsp;&nbsp;&nbsp;Clique no menu e conheça as funcionalidades: (apenas administradores)<br/> 
                &nbsp;&nbsp;&nbsp;- Cadastro/Visualização de Laudos <br/>
                &nbsp;&nbsp;&nbsp;- Cadastro/Visualização de Profissionais<br/>
                &nbsp;&nbsp;&nbsp;- Cadastro/Visualização de Clientes<br/>
                &nbsp;&nbsp;&nbsp;- Cadastro/Visualização de Usuários
            </p>
            <br/>   
    </div>

</body>
</html>