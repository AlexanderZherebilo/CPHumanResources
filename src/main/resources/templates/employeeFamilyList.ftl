<#import "parts/common.ftl" as c>

<@c.page "Члены семьи">
    <#include "parts/navbar.ftl">
<div class="container">
    <h2>Состав семьи</h2>
    <table class="table table-hover">
        <thead>
            <th>Принадлежность</th>
            <th>ФИО члена семьи</th>
            <th>Действия</th>
        </thead>
        <tbody>
        <#list Employee.getMembers() as member>
        <tr>
            <td>${member.relation}</td>
            <td>${member.surname}<br>${member.name} ${member.lastname}</td>
            <td><span class="btn btn-danger"><a class="btn text-white" href="/employee/family/deleting/${member.id}">Удалить</a></span></td>
        </tr>
        </#list>
        </tbody>
    </table>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseFamily" role="button" aria-expanded="false" aria-controls="collapseFamily">Добавить</a>
    <div class="collapse <#if message??>show</#if>" id="collapseFamily">
        <div class="form-group mt-3">
            <form method="post">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Принадлежность:</label>
                    <div class="col-sm-3">
                        <select name="relation" class="form-control">
                            <option value="Отец">Отец</option>
                            <option value="Мать">Мать</option>
                            <option value="Брат">Брат</option>
                            <option value="Сестра">Сестра</option>
                            <option value="Жена">Жена</option>
                            <option value="Муж">Муж</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Фамилия:</label>
                    <div class="col-sm-3">
                        <input type="text" name="surname" class="form-control" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Имя:</label>
                    <div class="col-sm-3">
                        <input type="text" name="name" class="form-control" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Отчество:</label>
                    <div class="col-sm-3">
                        <input type="text" name="lastname" class="form-control" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Дата рождения:</label>
                    <div class="col-sm-3">
                        <input type="date" name="birthday" class="form-control" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Место работы или учёбы:</label>
                    <div class="col-sm-3">
                        <input type="text" name="workPlace" class="form-control" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Место проживания:</label>
                    <div class="col-sm-3">
                        <input type="text" name="address" class="form-control" required/>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</div>
</@c.page>