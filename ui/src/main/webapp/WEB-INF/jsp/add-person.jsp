<%@
    taglib
    prefix = "c"
    uri    = "http://java.sun.com/jsp/jstl/core"
%>

<jsp:include page = "_header.jsp" />

    <h1>
        User details
    </h1>

    <form action = "/ui/add-new-person.do"
          method = "post"
    >

        <div class = "mb-3">
            <label  class = "form-label"
                    for   = "name"
            >
                First name
            </label>
            <input aria-label = "First name"
                   class      = "form-control"
                   id         = "name"
                   name       = "name"
                   type       = "text"
            />
        </div>

        <div class = "mb-3">
            <label  class = "form-label"
                    for   = "second_name"
            >
                Last name
            </label>
            <input aria-label = "Last name"
                   class      = "form-control"
                   id         = "second_name"
                   name       = "secondName"
                   type       = "text"
            />
        </div>

        <div class = "mb-3">
            <label  class = "form-label"
                    for   = "login"
            >
                User login
            </label>
            <input aria-label = "User login"
                   class      = "form-control"
                   id         = "login"
                   name       = "login"
                   type       = "text"
            />
        </div>

        <div class = "mb-3">
            <label  class = "form-label"
                    for   = "password"
            >
                Password
            </label>
            <input aria-label = "Password"
                   class      = "form-control"
                   id         = "password"
                   name       = "password"
                   type       = "password"
            />
            <input name  = "command"
                   type  = "hidden"
                   value = "new_user"
            />
        </div>

        <button class = "btn
                         btn-primary"
                type  = "submit"
        >
            Submit
        </button>

    </form>

<jsp:include page = "_footer.jsp" />