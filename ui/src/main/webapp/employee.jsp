<%@
    taglib
    prefix = "c"
    uri = "http://java.sun.com/jsp/jstl/core"
%>

<jsp:include page = "_header.jsp"/>

    <h1>
        Add new employee
    </h1>

    <table class = "table">

        <form action = "/ui/employee"
              method = "post"
        >

            <div class = "mb-3">
                <label class = "form-label"
                       for   = "firstName"
                >
                    Default file input example
                </label>

                <input class = "form-control"
                        id   = "firstName"
                        type = "text"
                />
            </div>

            <div class = "mb-3">
                <label class = "form-label"
                       for   = "formFileMultiple"
                >
                    Multiple files input example
                </label>

                <input class    = "form-control"
                       id       = "formFileMultiple"
                       multiple
                       type     = "file"
                />
            </div>

            <div class = "mb-3">
                <label class = "form-label"
                       for   = "formFileDisabled"
                >
                    Disabled file input example
                </label>

                <input class    = "form-control"
                       disabled
                       id       = "formFileDisabled"
                       type     = "file"
                />
            </div>

            <div class = "mb-3">
                <label class = "form-label"
                       for   = "formFileSm"
                >
                    Small file input example
                </label>

                <input class = "form-control
                                form-control-sm"
                       id    = "formFileSm"
                       type  = "file"
                />
            </div>

            <div>
                <label class = "form-label"
                       for   = "formFileLg"
                >
                    Large file input example
                </label>

                <input class = "form-control
                                form-control-lg"
                       id    = "formFileLg"
                       type  = "file"
                />
            </div>
        </form>

<jsp:include page = "_footer.jsp"/>