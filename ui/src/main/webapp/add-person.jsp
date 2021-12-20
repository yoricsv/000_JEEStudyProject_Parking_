<%@
    taglib
    prefix = "c"
    uri    = "http://java.sun.com/jsp/jstl/core"
%>
<jsp:include page = "_header.jsp" />

    <h1>
        Hello, world!
    </h1>

    <form action = "/ui/person"
          method = "post"
    >
        <div class = "input-group">
            <span class = "input-group-text">
                First and last name
            </span>
            <input aria-label = "First name"
                   class      = "form-control"
                   name       = "name"
                   type       = "text"
            />
            <input aria-label = "Last name"
                   class      = "form-control"
                   name       = "second_name"
                   type       = "text"
            />
            <input name  = "command"
                   type  = "hidden"
                   value = "new"
            />
            <button class = "btn
                             btn-primary"
                    type  = "submit"
            >
                Submit
            </button>
        </div>
    </form>

<jsp:include page = "_footer.jsp" />