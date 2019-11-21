<#import "parts/common.ftl" as c>

<@c.page "Редактирование образования">
    <#include "parts/navbar.ftl">
<div class="container-fluid my-2">
<h4>Редактировать образование</h4>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Тип образования:</label>
            <div class="col-sm-3">
                <select name="education" class="form-control">
                    <#list types as type>
                    <option value="${type}" <#if currentType?? && type == currentType>selected="selected"</#if>>${type}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Учреждение образования:</label>
            <div class="col-sm-3">
                <input type="text" name="institution" class="form-control" placeholder="Полное название учреждения" value="${institution!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Форма обучения:</label>
            <div class="col-sm-3">
                <select name="form" class="form-control">
                    <#list forms as form>
                        <option value="${form}" <#if currentForm?? && form == currentForm>selected="selected"</#if>>${form}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Факультет:</label>
            <div class="col-sm-3">
                <input type="text" name="faculty" class="form-control" placeholder="Факультет" value="${faculty!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Специальность:</label>
            <div class="col-sm-3">
                <input type="text" name="speciality" class="form-control" placeholder="Специальность" value="${speciality!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Квалификация:</label>
            <div class="col-sm-3">
                <input type="text" name="qualification" class="form-control" placeholder="Квалификация" value="${qualification!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата начала обучения:</label>
            <div class="col-sm-3">
                <input type="date" name="start" class="form-control" value="${start!''}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата окончания обучения:</label>
            <div class="col-sm-3">
                <input type="date" name="finish" class="form-control" value="${finish!''}" required/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</div>
</@c.page>