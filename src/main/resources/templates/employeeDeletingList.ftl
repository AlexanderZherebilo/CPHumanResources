<#import "parts/common.ftl" as c>

<@c.page "Удаление сотрудников">
    <#include "parts/navbar.ftl">
<div class="container">
    <h2>Список сотрудников</h2>
    <table class="table table-hover">
        <thead>
        <th>ФИО сотрудника</th>
        <th>Отдел и должность</th>
        <th>Аккаунт</th>
        <th>Действия</th>
        </thead>
        <tbody>
        <#list employees as e>
        <tr>
            <td>${e.passport.surname}<br>${e.passport.name} ${e.passport.lastname}</td>
            <td></td>
            <td><#if !e.hasAccount()>Нет аккаунта</#if><#if e.hasAccount() && e.account.isAdmin()>Администратор</#if><#if e.hasAccount() && !e.account.isAdmin()>Пользователь</#if></td>
            <td><#if !e.hasAccount() || (e.hasAccount() && !(e.account.username == name))> <span class="btn btn-danger"><a class="btn text-white" href="/employee/employeeList/deleting/${e.id}">Удалить</a></span></#if></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</@c.page>