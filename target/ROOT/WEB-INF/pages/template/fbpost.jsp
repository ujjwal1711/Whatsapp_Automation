<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.2&appId=1200270030109414&autoLogAppEvents=1';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<c:forEach items="${POSTS}" var="post">
    <div class="col-sm-6 col-xs-12 pb--30" style="position: absolute; left: 0px; top: 1158px;">
        <div class="post--item" data-scroll-reveal="bottom" data-sr-id="7" style="; visibility: visible;  -webkit-transform: translateY(0) scale(1); opacity: 1;transform: translateY(0) scale(1); opacity: 1;-webkit-transition: box-shadow 0.25s ease-in-out 0s, -webkit-transform 0.8s cubic-bezier(0.6, 0.2, 0.1, 1) 0s, opacity 0.8s cubic-bezier(0.6, 0.2, 0.1, 1) 0s; transition: box-shadow 0.25s ease-in-out 0s, transform 0.8s cubic-bezier(0.6, 0.2, 0.1, 1) 0s, opacity 0.8s cubic-bezier(0.6, 0.2, 0.1, 1) 0s; ">
            ${post.embedCode}
        </div>
    </div>
</c:forEach>