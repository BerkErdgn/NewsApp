
# News App

NewsApp allows users to follow current news anytime, anywhere and helps users to easily save news and get the news they want quickly.

The news application called "NewsApp" is a customizable and user-friendly news application that provides users with the latest news instantly. Users can search for news topics they want within the application and save the news. If they save news, the application provides easy access to the saved news and users can read it whenever they want.

(My purpose of developing this app is to learn jetpack compose.)



## Technologies Used
- Jetpack Compose
- MVVM
- Corutines
- LiveData
- Room
- Dagger Hilt
- Retrofit
- Navigation
- LottieFiles



## API Usage

- Base Url:
```http
    https://newsapi.org/

```
----
- To get all news:
```http
    @GET v2/top-headlines
```

| Parameter | Type     | Explanation                |
| :-------- | :------- | :------------------------- |
| `country ` | `string` | to get the news in **that country**. | 
| `apiKey` | `string` | **Necessary**. Your API key. |

----
- To get a list of desired news in the search result:
```http
    @GET v2/everything
```

| Parameter | Type     | Explanation                |
| :-------- | :------- | :------------------------- |
| `q ` | `string` | The **searched word** is entered here. | 
| `apiKey` | `string` | **Necessary**. Your API key. |

----
- To reach the details of the desired news:
```http
    @GET v2/everything
```

| Parameter | Type     | Explanation                |
| :-------- | :------- | :------------------------- |
| `q ` | `string` | The **title** of the news is entered here. | 
| `apiKey` | `string` | **Necessary**. Your API key. |

## Screenshots

Splash Screen | Splash Screen |Home Screen|Detail Screen|
 --- | --- |  --- | --- | 
![](https://github.com/BerkErdgn/NewsApp/blob/main/sc/NewsApp-1.png?raw=true)| ![](https://github.com/BerkErdgn/NewsApp/blob/main/sc/NewsApp-2.png?raw=true) |![](https://github.com/BerkErdgn/NewsApp/blob/main/sc/NewsApp-3.png?raw=true) |![](https://github.com/BerkErdgn/NewsApp/blob/main/sc/NewsApp-4.png?raw=true)

Search Screen | Save Screen (Empty) |Save Screen|
 --- | --- |  --- |
![](https://github.com/BerkErdgn/NewsApp/blob/main/sc/NewsApp-5.png?raw=true)| ![](https://github.com/BerkErdgn/NewsApp/blob/main/sc/NewsApp-6.png?raw=true) |![](https://github.com/BerkErdgn/NewsApp/blob/main/sc/NewsApp-7.png?raw=true) |


## Download  

To download the project

```bash 
  1-Press the green "Code" button at the top right of this page.
  2-Click on Download ZIP
  3-Extract the ZIP and open it to Android Studio
```
As an alternative

You can directly download the ZIP by clicking the [link here](https://github.com/BerkErdgn/NewsApp/archive/refs/heads/main.zip).
## Find a bug?

If you found an issue or would like to submit an improvement to this project, please submit an issue using the issues tab above.
Thank you very much.
