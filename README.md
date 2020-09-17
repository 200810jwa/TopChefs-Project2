#  Pantry Meals

Team Name: Top Chefs 
* Team Members: Leron Charles, Andrew Lukens and Zach Quinn
* External API: http://www.recipepuppy.com/about/api/
<h2>Project Description:</h2> <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The Pantry Meals application implements a Spring framework backend,
by using Hibernate to establish connection and persist data to the database.
Users are able to add ingredients located in their pantry through an Angular Frontend which
returns recommended recipes based on the ingredients. The project uses Jenkins to automate CI/CD operations.
JUnit 5 is used to provide test coverage while Selenium is used to create end to end tests. </p>
<ul> <h2>Core Features:</h2>
  <li>Suggesting recipes based on current ingredients in the user's kitchen.</li>
  <li>Tracking Previously made recipes for users.</li>
  <li>Tracking “Favorited” recipes for the user’s</li>
  <li>Tracking user ratings of recipes</li>
</ul>
<ul><h2>Stretch Goals:</h2>
  <li>User’s can filter results by dietary restriction i.e. allergies, vegetarian, lactose intolerant</li>
  <li>User’s can create personalized lists to save recipes in i.e. good for parties, lunch<li>
</ul>
<h2>User Stories:</h2>
<ul>
<li>Given a user is signed in, when a user inputs the ingredients they have in their kitchen, then they will receive a list of recipes they can make using those ingredients.</li>
<li>Given a user finds a recipe they like, when they click on the recipe, then they will be sent to the website with that recipe.</li>
<li>Given a user has received a recipe, when they “like” the recipe, then it is added to their list of “favorite” recipes.
<li>Given a user has picked a recipe, when they choose to rate the recipe, then they’re personal rating will be saved to their account and the general rating will be impacted. Given a user has entered the ingredients in their kitchen, when a user selects criteria to sort their results by, then the results shown will reflect the criteria (i.e. sort by rating)</li>
<li>Given a user is new, when visiting the site, then they can create a profile with a unique username and password.</li> 
<li>Given a user has an account, when they visit the site, then they can log in and view recipes they have made in the past, as well as their favorites.</li>
<li>Given a user is signed in, when a user changes their account information, then the database will reflect those changes.</li>
</ul>
