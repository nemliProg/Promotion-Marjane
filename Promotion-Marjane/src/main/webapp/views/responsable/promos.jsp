<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../inc/top.jsp" />
<div x-data="{ open: true }">
  <!-- Off-canvas menu for mobile, show/hide based on off-canvas menu state. -->
  <div x-show="open" class="fixed inset-0 flex z-40 md:hidden" role="dialog" aria-modal="true">
    <div class="fixed inset-0 bg-gray-600 bg-opacity-75" aria-hidden="true"></div>
    <!--
      Off-canvas menu, show/hide based on off-canvas menu state.
    -->
    <div  class="relative flex-1 flex flex-col max-w-xs w-full bg-white">
      <!--
        Close button, show/hide based on off-canvas menu state.
      -->
      <div  class="absolute top-0 right-0 -mr-12 pt-2">
        <button x-on:click="open = ! open" type="button" class="ml-1 flex items-center justify-center h-10 w-10 rounded-full focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white">
          <span class="sr-only">Close sidebar</span>
          <!-- Heroicon name: outline/x -->
          <svg class="h-6 w-6 text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
          </svg>
        </button>
      </div>

      <div class="flex-1 h-0 pt-5 pb-4 overflow-y-auto">
        <div class="flex-shrink-0 flex items-center px-4">
          <img class="h-8 w-auto" src="./images/logos/logo_marjane.svg" alt="Workflow">
        </div>
        <nav class="mt-5 px-2 space-y-1">
          <!-- Current: "bg-gray-100 text-gray-900", Default: "text-gray-600 hover:bg-gray-50 hover:text-gray-900" -->
          <a href="/responsable/promos" class="bg-gray-100 text-gray-900 group flex items-center px-2 py-2 text-base font-medium rounded-md">
            <!--
              Heroicon name: outline/home

              Current: "text-gray-500", Default: "text-gray-400 group-hover:text-gray-500"
            -->
            <svg class="text-gray-500 mr-4 flex-shrink-0 h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6" />
            </svg>
            Promos
          </a>

          <a href="/responsable/products" class="text-gray-600 hover:bg-gray-50 hover:text-gray-900 group flex items-center px-2 py-2 text-base font-medium rounded-md">
            <!-- Heroicon name: outline/folder -->
            <svg class="text-gray-400 group-hover:text-gray-500 mr-4 flex-shrink-0 h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 7v10a2 2 0 002 2h14a2 2 0 002-2V9a2 2 0 00-2-2h-6l-2-2H5a2 2 0 00-2 2z" />
            </svg>
            Products
          </a>

        </nav>
      </div>
      <div class="flex-shrink-0 flex border-t border-gray-200 p-4">
        <div class="flex-shrink-0 w-full group block">
          <div class="flex content-center justify-between gap-3">
            <div class="ml-3">
              <p class="text-sm font-medium text-gray-700 group-hover:text-gray-900"><c:out value="${responsable.nom}" /> <c:out value="${responsable.prenom}" /></p>
              <p class="text-xs font-medium text-gray-500 group-hover:text-gray-700">Responsable</p>
            </div>
            <jsp:include page="../components/logout-button.jsp" />
          </div>
        </div>
      </div>
    </div>

    <div class="flex-shrink-0 w-14">
      <!-- Force sidebar to shrink to fit close icon -->
    </div>
  </div>

  <!-- Static sidebar for desktop -->
  <div class="hidden md:flex md:w-64 md:flex-col md:fixed md:inset-y-0">
    <!-- Sidebar component, swap this element with another sidebar if you like -->
    <div class="flex-1 flex flex-col min-h-0 border-r border-gray-200 bg-white">
      <div class="flex-1 flex flex-col pt-5 pb-4 overflow-y-auto">
        <div class="flex items-center flex-shrink-0 px-4">
          <img class="h-16 w-36" src="../../images/logos/logo_marjane.svg" alt="Workflow">
        </div>
        <nav class="mt-5 flex-1 px-2 bg-white space-y-1">
          <!-- Current: "bg-gray-100 text-gray-900", Default: "text-gray-600 hover:bg-gray-50 hover:text-gray-900" -->
          <a href="/responsable/promos" class="bg-gray-100 text-gray-900 group flex items-center px-2 py-2 text-sm font-medium rounded-md">
            <!--
              Heroicon name: outline/home

              Current: "text-gray-500", Default: "text-gray-400 group-hover:text-gray-500"
            -->
            <svg class="text-gray-500 mr-3 flex-shrink-0 h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6" />
            </svg>
            Promos
          </a>

          <a href="/responsable/products" class="text-gray-600 hover:bg-gray-50 hover:text-gray-900 group flex items-center px-2 py-2 text-sm font-medium rounded-md">
            <!-- Heroicon name: outline/folder -->
            <svg class="text-gray-400 group-hover:text-gray-500 mr-3 flex-shrink-0 h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 7v10a2 2 0 002 2h14a2 2 0 002-2V9a2 2 0 00-2-2h-6l-2-2H5a2 2 0 00-2 2z" />
            </svg>
            Products
          </a>

        </nav>
      </div>
      <div class="flex-shrink-0 flex border-t border-gray-200 p-4">
        <div class="flex-shrink-0 w-full group block">
          <div class="flex content-center justify-between gap-3">
            <div class="ml-3">
              <p class="text-sm font-medium text-gray-700 group-hover:text-gray-900"><c:out value="${responsable.nom}" /> <c:out value="${responsable.prenom}" /></p>
              <p class="text-xs font-medium text-gray-500 group-hover:text-gray-700">Responsable</p>
            </div>
            <jsp:include page="../components/logout-button.jsp" />
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="md:pl-64 flex flex-col flex-1">
    <div class="sticky top-0 z-10 md:hidden pl-1 pt-1 sm:pl-3 sm:pt-3 bg-white">
      <button x-on:click="open = ! open" type="button" class="-ml-0.5 -mt-0.5 h-12 w-12 inline-flex items-center justify-center rounded-md text-gray-500 hover:text-gray-900 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500">
        <span class="sr-only">Open sidebar</span>
        <!-- Heroicon name: outline/menu -->
        <svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
        </svg>
      </button>
    </div>
    <main class="flex-1">
      <div class="py-6">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 md:px-8">
          <h1 class="text-2xl font-semibold text-gray-900">Dashboard</h1>
        </div>
        <div class="max-w-7xl mx-auto px-4 sm:px-6 md:px-8">
          <!-- Replace with your content -->
          <div class="py-4">
            <h2 class="font-bold text-2xl">List of Promotions</h2>
            <div class="p-4">
              <div class="flex flex-col">
                <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                  <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                    <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
                      <table class="min-w-full divide-y divide-gray-200">
                        <thead class="bg-gray-50">
                        <tr>
                          <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Category Name</th>
                          <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Percentage</th>
                          <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">description</th>
                          <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">status</th>
                          <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Start date</th>
                          <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">End date</th>
                          <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                            Decision
                          </th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- Odd row -->
                        <c:forEach items="${promotions}" var="promotion" varStatus="i" >
                          <c:choose>
                            <c:when test="${i.count % 2 == 0 }">
                              <tr class="bg-white">
                                <td class="px-6 py-2 whitespace-nowrap text-sm font-medium text-gray-900"><c:out value="${promotion.categorieByIdCat.nom}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap text-sm text-gray-500"><c:out value="${promotion.pourcentage}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap text-sm text-gray-500"><c:out value="${promotion.description}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap">
                                  <span class="px-2 py-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-yellow-100 text-yellow-800"> <c:out value="${promotion.status}" /></span>
                                </td>
                                <td class="px-6 py-2 whitespace-nowrap text-sm text-gray-500"><c:out value="${promotion.promoStartDate}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap text-sm text-gray-500"><c:out value="${promotion.promoEndDate}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap text-right text-sm font-medium flex items-center gap-2">
                                  <form class="m-0" method="post" action="/responsable/promos" >
                                    <input type="hidden" name="id" value="<c:out value="${promotion.id}" />">
                                    <button name="accept" type="submit" class="py-2 px-2 text-sm font-medium text-[#085da8] focus:outline-none bg-white rounded-lg border border-[#085da8] hover:bg-[#085da8] hover:bg-border-[#085da8] hover:text-white ">Accept</button>
                                  </form>
                                  <a href="/responsable/promos/reject?id=<c:out value="${promotion.id}" />">
                                    <button  type="button" class="py-2 px-2 text-sm font-medium text-[#085da8] focus:outline-none bg-white rounded-lg border border-[#085da8] hover:bg-[#085da8] hover:bg-border-[#085da8] hover:text-white ">Reject</button>
                                  </a>
                                </td>
                              </tr>
                            </c:when>
                            <c:otherwise>
                              <tr class="bg-gray-50 py-2">
                                <td class="px-6 py-2 whitespace-nowrap text-sm font-medium text-gray-900"><c:out value="${promotion.categorieByIdCat.nom}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap text-sm text-gray-500"><c:out value="${promotion.pourcentage}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap text-sm text-gray-500"><c:out value="${promotion.description}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap">
                                  <span class="px-2 py-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-yellow-100 text-yellow-800"> <c:out value="${promotion.status}" /></span>
                                </td>
                                <td class="px-6 py-2 whitespace-nowrap text-sm text-gray-500"><c:out value="${promotion.promoStartDate}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap text-sm text-gray-500"><c:out value="${promotion.promoEndDate}" /></td>
                                <td class="px-6 py-2 whitespace-nowrap text-right text-sm font-medium flex items-center gap-2">
                                  <form class="m-0" method="post" action="/responsable/promos" >
                                    <input type="hidden" name="id" value="<c:out value="${promotion.id}" />">
                                    <button type="submit" class="py-2 px-2 text-sm font-medium text-[#085da8] focus:outline-none bg-white rounded-lg border border-[#085da8] hover:bg-[#085da8] hover:bg-border-[#085da8] hover:text-white ">Accept</button>
                                  </form>
                                  <a href="/responsable/promos/reject?id=<c:out value="${promotion.id}" />">
                                    <button  type="submit" class="py-2 px-2 text-sm font-medium text-[#085da8] focus:outline-none bg-white rounded-lg border border-[#085da8] hover:bg-[#085da8] hover:bg-border-[#085da8] hover:text-white ">Reject</button>
                                  </a>
                                </td>
                              </tr>
                            </c:otherwise>
                          </c:choose>
                        </c:forEach>

                        <!-- More people... -->
                        </tbody>
                      </table>
                      <c:if test="${totalOfPages > 1}">
                        <nav aria-label="Page navigation">
                          <ul class="inline-flex">
                            <li><button class="h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white rounded-l-lg focus:shadow-outline hover:bg-indigo-100">Prev</button></li>
                            <c:forEach var="i" begin="1" end="${totalOfPages}" step="1">
                              <li><a href="${pageContext.request.contextPath}/responsable/promos/<c:out value="${i}" />" class="flex items-center h-10 px-5 align-middle <c:if test="${currentPage != i}"><c:out value="text-indigo-600" /> </c:if> transition-colors duration-150 bg-white focus:shadow-outline hover:bg-indigo-100 <c:if test="${currentPage == i}"><c:out value="text-white bg-blue-800 hover:bg-blue-800" /> </c:if>" ><c:out value="${ i }" /></a></li>
                            </c:forEach>
                            <li><button class="h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white rounded-r-lg focus:shadow-outline hover:bg-indigo-100">Next</button></li>
                          </ul>
                        </nav>
                      </c:if>
                    </div>
                    <c:if test="${message != null}" >
                      <h3 class="p-4 mt-2 text-[#ffe800] bg-[#085da8] rounded text-center text-xl ">
                        <c:out value="${message}" />
                      </h3>
                    </c:if>
                  </div>
                </div>
              </div>
            </div>

          </div>
          <!-- /End replace -->
        </div>
      </div>
    </main>
  </div>
</div>
<jsp:include page="../inc/bottom.jsp" />
