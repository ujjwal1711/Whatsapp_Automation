<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach items="${POSTS}" var="post">
    <div class="col-sm-6 col-xs-12 pb--30" style="position: absolute; left: 0px; top: 1158px;">
        <!-- Post Item Start -->
        <div class="post--item" data-scroll-reveal="bottom" data-sr-id="7" style="; visibility: visible;  -webkit-transform: translateY(0) scale(1); opacity: 1;transform: translateY(0) scale(1); opacity: 1;-webkit-transition: box-shadow 0.25s ease-in-out 0s, -webkit-transform 0.8s cubic-bezier(0.6, 0.2, 0.1, 1) 0s, opacity 0.8s cubic-bezier(0.6, 0.2, 0.1, 1) 0s; transition: box-shadow 0.25s ease-in-out 0s, transform 0.8s cubic-bezier(0.6, 0.2, 0.1, 1) 0s, opacity 0.8s cubic-bezier(0.6, 0.2, 0.1, 1) 0s; ">
            <!-- Post Audio Start -->
            <div class="post--audio embed-responsive embed-responsive-16by9">
                <iframe width="100%" src="${post.url}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
            <!-- Post Audio End -->

            <!-- Post Info Start -->
            <div class="post--info">
                <!-- Post Meta Start -->
                <div class="post--meta">
                    <ul class="nav">
                        <li>
                            <a href="demo/socifly/html/blog-sidebar-left.html#">
                                <img src="/static/template/SociFly - Multipurpose Social Network HTML5 Template_files/avatar-small-06.jpg" alt="">
                                <span>${post.author_name}</span>
                            </a>
                        </li>
                        <li>
                            <a href="demo/socifly/html/blog-sidebar-left.html#">
                                <i class="mr--8 fa fa-calendar-o"></i>
                                <span>9 Dec, 2018</span>
                            </a>
                        </li>
                        <li>
                            <a href="demo/socifly/html/blog-sidebar-left.html#">
                                <i class="mr--8 fa fa-comments-o"></i>
                                <span>100k Comments</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <!-- Post Meta End -->

                <!-- Post Title Start -->
                <div class="post--title mt--10">
                    <h3 class="h6">
                        <a href="demo/socifly/html/blog-details.html" class="btn-link">${post.title}</a>
                    </h3>
                </div>
                <!-- Post Title End -->

                <!-- Post Content Start -->
                <div class="post--content text-darker mt--10" style="    max-height: 70px;overflow: hidden;">
                    <p>${post.description}</p>
                </div>
                <!-- Post Content End -->

                <!-- Post Action Start -->
                <div class="post--action text-darkest mt--8">
                    <a href="demo/socifly/html/blog-details.html" class="btn-link">Continue Reading<i class="ml--10 text-primary fa fa-caret-right"></i></a>
                </div>
                <!-- Post Action End -->
            </div>
            <!-- Post Info End -->
        </div>
        <!-- Post Item End -->
    </div>
</c:forEach>