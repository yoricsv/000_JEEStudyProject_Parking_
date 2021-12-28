<!doctype html>
<html lang = "en">
    <head>
        <!-- Required meta tags -->

        <meta charset = "utf-8">
        <meta content = "width=device-width,
                         initial-scale=1"
              name    = "viewport"
        >

        <!-- Bootstrap CSS -->

        <link crossorigin = "anonymous"
              href        = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              integrity   = "sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              rel         = "stylesheet"
        >

        <title>
            Hello, world!
        </title>

    </head>
        <body>
            <nav class = "bg-light
                          navbar
                          navbar-expand-lg
                          navbar-light"
            >
                <div class = "container-fluid">

                    <a class = "navbar-brand"
                       href  = "#"
                    >
                        Navbar
                    </a>

                    <button aria-controls  = "navbarSupportedContent"
                            aria-expanded  = "false"
                            aria-label     = "Toggle
                                              navigation"
                            class          = "navbar-toggler"
                            data-bs-target = "#navbarSupportedContent"
                            data-bs-toggle = "collapse"
                            type           = "button"
                    >
                        <span class = "navbar-toggler-icon">
                        </span>
                    </button>

                    <div class = "collapse
                                  navbar-collapse"
                         id    = "navbarSupportedContent"
                    >
                        <ul class = "navbar-nav
                                     mb-2
                                     me-auto
                                     mb-lg-0"
                        >
                            <li class = "nav-item">
                                <a aria-current = "page"
                                   class        = "nav-link active"
                                   href         = "/ui/index.html"
                                >
                                    Home
                                </a>
                            </li>
                            <li class = "nav-item">
                                <a class = "nav-link"
                                   href  = "#"
                                >
                                    Link
                                </a>
                            </li>

                            <li class = "dropdown
                                         nav-item"
                            >
                                <a aria-expanded  = "false"
                                   class          = "nav-link
                                                     dropdown-toggle"
                                   data-bs-toggle = "dropdown"
                                   href           = "#"
                                   id             = "navbarDropdown"
                                   role           = "button"
                                >
                                    Users
                                </a>

                                <ul aria-labelledby = "navbarDropdown"
                                    class           = "dropdown-menu"
                                >
                                    <li>
                                        <a class = "dropdown-item"
                                           href  = "/ui/add-new-user.html"
                                        >
                                            Add new user
                                        </a>
                                    </li>
                                    <li>
                                        <a class = "dropdown-item"
                                           href  = "#"
                                        >
                                            Another action
                                        </a>
                                    </li>
                                    <li>
                                        <hr class = "dropdown-divider">
                                    </li>
                                    <li>
                                        <a class = "dropdown-item"
                                           href  = "#"
                                        >
                                            Something else here
                                        </a>
                                    </li>
                                </ul>
                            </li>

                            <li class = "nav-item">
                                <a class = "nav-link
                                            disabled"
                                >
                                    Disabled
                                </a>
                            </li>
                        </ul>

                        <form action = "/ui/search.html"
                              class  = "d-flex"
                        >
                            <input aria-label  = "Search"
                                   class       = "form-control
                                                  me-2"
                                   name        = "str"
                                   placeholder = "Search"
                                   type        = "search"
                            />
                            <button class = "btn
                                             btn-outline-success"
                                    type  = "submit"
                            >
                                Search
                            </button>
                        </form>
                    </div>
                </div>
            </nav>