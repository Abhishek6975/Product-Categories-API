
# Product-Categories-API

The Product-Categories API is a RESTful web service designed to manage products and their categories. It provides endpoints for creating, updating, deleting, and retrieving products and categories. With this API, you can efficiently organize your products into different categories, making it easy to manage and retrieve them.



## Features

- Product Management: Create, update, delete, and retrieve product information.
- Category Management: Organize products into categories and manage category details.
- Pagination and Sorting: Easily paginate through large sets of products and categories, with sorting options for better organization.
- Error Handling: Robust error handling ensures smooth operation and easy troubleshooting.
- Security:DTO (Data Transfer Object) classes play a crucial role in maintaining security within the Product-Categories API. These classes serve as an intermediary between the client and the API endpoints, ensuring that sensitive data is handled securely and only necessary information is transmitted over the network.


## Used By

This mini project i used following Tools:
- Use Spring boot

- Use Rest controller

- MySQL DataBase Management System for DataBase configuration.

- Use annotation based configuration (Not XML).

- JPA & Hibernate

- Maven help build automation tools for Java projects. They manage project dependencies.

- PostMan for Testing Restful API's.



## Create categories

To Run following url on postMan for create categories:

```bash
  http://localhost:8080/categories/create
```


## View All categories

```bash
 http://localhost:8080/categories/view
```

## view All Categories By Pagination

```bash
http://localhost:8080/categories/view?pageNumber=0&pageSize=3
```

## Create product 
- Note :- At the time of create Product, first Fetch Product Related Category Present in Database or Not through category id then Product is Created and Add in category List.
```bash
 http://localhost:8080/product/create/6
```
## view All Product
```bash
http://localhost:8080/product/view
```

## view All Product
```bash
http://localhost:8080/product/view
```

## view All Product By Pagination
```bash
http://localhost:8080/product/view?pageNumber=2&pageSize=4
```

## view All Product By Pagination + sortBy product id.
```bash
http://localhost:8080/product/view?pageNumber=0&pageSize=10&sortBy=productId
```







## Screenshots

![create-Categories](https://github.com/Abhishek6975/Product-Categories-API/assets/100897545/350736a6-3830-48fe-b0af-16f541a3b5b4)

## Screenshots
![categoriesById](https://github.com/Abhishek6975/Product-Categories-API/assets/100897545/6e9be7e5-6799-4f58-a6c4-b548ff6309b8)

## Screenshots

![product-views](https://github.com/Abhishek6975/Product-Categories-API/assets/100897545/03e01e56-7592-438a-8bd8-b96369dfbd30)

## Screenshots

![Product-Pagination](https://github.com/Abhishek6975/Product-Categories-API/assets/100897545/96f5d84b-dea6-47b4-acda-c27efc72e6fd)


## 🚀 About Me
hi my name is Abhishek Narkhede,
As a recent
graduate with a Bachelor Of Engineering in Computer Engineering from Pune University.

i have intern Exprince in Xform Technologies Pvt.Ltd as Java Developer (Paid Internship) and HeatCorn System Pvt ltd as C++ Developer.

i have Strong knowledge about java Full Stack and also good knowledge about Data Structure and Alogorithums and Now Currently i am working on E-Commerce Web Application using Spring Boot.




## 🛠 Skills
- Languages: Java, C/C++, HTML/CSS, JavaScript, SQL
- Developer Tools: VS Code, Eclipse, Android Studio
- Technologies/ Frameworks: Jsp, Servlet, Spring Boot, Hibernate ORM Model  


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://abhishek6975.github.io/portfolio_website.github.io/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/iamabhisheknarkhede/)
[![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=for-the-badge&logo=leetcode&logoColor=white)](https://leetcode.com/u/abhisheknarkharkhede083/)


