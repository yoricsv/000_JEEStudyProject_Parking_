<%@
    taglib
    prefix = "c"
    uri    = "http://java.sun.com/jsp/jstl/core"
%>
<%@
    taglib
    prefix = "f"
    uri    = "http://www.springframework.org/tags/form"
%>

<jsp:include page = "_header.jsp" />

    <h1>
        User details
    </h1>

    <f:form action         = "/ui/add-new-person.do"
            enctype        = "multipart/form-data"
            method         = "post"
            modelAttribute = "addNewUserCommand"
    >

        <div class = "mb-3">
            <label  class = "form-label"
                    for   = "name"
            >
                First name
            </label>
            <f:input aria-label = "First name"
                     class      = "form-control"
                     id         = "name"
                     name       = "name"
                     path       = "name"
                     type       = "text"
            />
        </div>

        <div class = "mb-3">
            <label  class = "form-label"
                    for   = "surname"
            >
                Last name
            </label>
            <f:input aria-label = "Surname"
                     class      = "form-control"
                     id         = "surname"
                     name       = "surname"
                     path       = "surname"
                     type       = "text"
            />
        </div>

        <div class = "mb-3">
            <label  class = "form-label"
                    for   = "login"
            >
                User login
            </label>
            <f:input aria-label = "User login"
                     class      = "form-control"
                     id         = "login"
                     name       = "login"
                     path       = "login"
                     type       = "text"
            />
        </div>

        <div class = "mb-3">
            <label  class = "form-label"
                    for   = "password"
            >
                Password
            </label>
            <f:input aria-label = "Password"
                     class      = "form-control"
                     id         = "password"
                     name       = "password"
                     path       = "password"
                     type       = "password"
            />
            <f:input name  = "command"
                     path  = "command"
                     type  = "hidden"
                     value = "new_user"
            />
            <f:errors cssClass = "error"
                      path     = "password"
            />
        </div>

        <div class="mb-3">
            <label class = "form-label"
                   for   = "file"
            >
                Photo
            </label>

            <input id   = "file"
                   name = "file"
                   type = "file"
            />
        </div>

        <f:button class = "btn
                           btn-primary"
                  type  = "submit"
        >
            Submit
        </f:button>


        <div class = "mb-3">
            <f:errors path = "*" />
        </div>
    </f:form>

<jsp:include page = "_footer.jsp" />