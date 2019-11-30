<#import "parts/common.ftl" as c>

<@c.page "Редактирование пользователя">
    <#include "parts/navbar.ftl">
<div class="container">
    <h3>Редактирование ролей</h3>
    <form action="/user" method="post">
        <div class="form-group row col-sm-3">
            <input type="text" class="form-control" value="${user.username}" name="username">
        </div>
        <#list roles as role>
            <div class="form-group row col-sm-3">
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Сохранить</button>
    </form>
</div>
</@c.page>