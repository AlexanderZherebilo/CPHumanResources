<#import "parts/common.ftl" as c>

<@c.page "Список сотрудников">
    <#include "parts/navbar.ftl">
    <div class="row">
        <div class="col-md-2">
            <#if isAdmin>
                <#include "parts/employeeListMenu.ftl">
            </#if>
        </div>
        <div class="container col-md-10">
            <h1 class="text-center">Сотрудники компании</h1>
            <div class="card-columns">
                <#list employees as employee>
                        <div class="card my-2" style="width:290px">
                            <#if employee.photo??>
                                <img src="/img/${employee.photo}" height="250px" width="200px" class="card-img-top">
                            </#if>
                            <#if !employee.photo??>
                                <#switch employee.passport.gender>
                                    <#case "Мужской"> <img src="/img/Male.jpg" height="250px" width="250px" class="card-img-top"><#break>
                                    <#case "Женский"> <img src="/img/Female.jpg" height="250px" width="250px" class="card-img-top"><#break>
                                </#switch>
                            </#if>
                            <div class="card-body">
                                <a href="${employee.id}" class="hyperlink">
                                    <h4 class="card-title text-center">${employee.passport.surname} ${employee.passport.name} ${employee.passport.lastname}</h4>
                                </a>
                                <p><b>Отдел: </b></p>
                                <p><b>Должность: </b></p>
                            </div>
                        </div>
                </#list>
            </div>
        </div>
    </div>
</@c.page>