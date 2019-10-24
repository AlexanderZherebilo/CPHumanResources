<#import "parts/common.ftl" as c>

<@c.page "Управление пользователями">
    <#include "parts/navbar.ftl">
List of users

<table class="table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="user/${user.id}">Edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>