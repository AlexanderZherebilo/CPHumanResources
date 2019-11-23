<#import "parts/common.ftl" as c>

<@c.page "Добавление сотрудника в базу">
    <#include "parts/navbar.ftl">
    <div class="container-fluid my-2">
        <h2>Добавление сотрудника</h2>
        <form method="post" enctype="multipart/form-data">
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
                <label class="col-sm-2 col-form-label">Пол:</label>
                <div class="col-sm-3">
                    <select name="gender" class="form-control">
                    <#list genders as gender>
                        <option value="${gender}">${gender}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Семейное положение:</label>
                <div class="col-sm-3">
                    <select name="maritalStatus" class="form-control">
                    <#list marriges as marrige>
                        <option value="${marrige}">${marrige}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Образование:</label>
                <div class="col-sm-3">
                    <select name="education" class="form-control">
                    <#list types as type>
                        <option value="${type}">${type}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Адрес:</label>
                <div class="col-sm-3">
                    <input type="text" name="address" class="form-control" required/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Мобильный телефон:</label>
                <div class="col-sm-3">
                    <input type="tel" name="telephone" class="form-control" placeholder="Номер в международном формате" required/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Отдел:</label>
                <div class="col-sm-3">
                    <select name="department" class="form-control">
                    <#list departments as department>
                        <option value="${department.id}" selected="selected">${department.name}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Должность:</label>
                <div class="col-sm-3">
                    <select name="position" class="form-control">
                    <#list positions as position>
                        <option value="${position.id}" selected="selected">${position.name}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Пенсионный код:</label>
                <div class="col-sm-3">
                    <input type="number" name="retirementCode" pattern="[0-9]{6}" class="form-control" required/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Табельный номер:</label>
                <div class="col-sm-1">
                    <input type="number" id="personnel" name="personnelNumber" class="form-control" readonly required/>
                </div>
                <button type="button" onclick="generate();" class="btn btn-primary">Сгенерировать</button>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Фотография:</label>
                <div class="col-sm-3">
                    <input type="file" name="photo" id="customFile">
                    <label class="custom-file-label" for="customFile">Размер до 1 Мб</label>
                </div>
            </div>
            <h5 class="text-warning">Паспортные данные:</h5>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Серия паспорта:</label>
                <div class="col-sm-1">
                    <input type="text" maxlength="2" name="series" class="form-control" required/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Номер паспорта:</label>
                <div class="col-sm-3">
                    <input type="text" name="number" pattern="[0-9]{7}" title="Используйте только цифры" class="form-control" required/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Кем выдан:</label>
                <div class="col-sm-3">
                    <input type="text" name="issuedBy" placeholder="Организация, выдавшая паспорт" class="form-control" required/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Дата выдачи:</label>
                <div class="col-sm-3">
                    <input type="date" name="dateOfIssue" class="form-control" required/>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Добавить</button>
        </form>
    </div>

    <script>
        function generate() {
            var num = Math.floor(Math.random() * (9999999 - 1000000 + 1) + 1000000);
            $("#personnel").val(num);
        }
    </script>
</@c.page>