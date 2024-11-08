### Главный api системы.
 **/technic_models/api_v1/registry_main/technic_models**

    из запроса исключим необязательные поля.
    "technicsTypeId": 0,
    "colorId": 0,
    "modelOptionsValuesStrings": []

    POST http://localhost:8091/api_v1/registry_main/technic_models
    Content-Type: application/json
    
    {
    "technicsModelNameTerm": "",
    "priceFrom": 0,
    "priceTo": 100000000,
    "pageNumber": 0,
    "pageSize": 100,
    "sortBy": "name",
    "order": "ASC"
    }

    получаем все модели(их меньше 100 на 1 странице сортированные по имени)


Делаем тотже запрос, но c  "technicsModelNameTerm": "mega"

    RESPONSE
    
    "content": [
            {
            "id": 32,
            "name": "MEGA PYLESOS 3000",
            "color": null,
            "serialNumber": "MGPLSL3K_3000",
            "modelSize": null,
            "price": 1000000.00,
            "inStock": false,
            "modelOptionsValues": []
            }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
            },
        "pageNumber": 0,
        "pageSize": 100,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "first": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "numberOfElements": 1,
    "size": 100,
    "number": 0,
    "empty": false
    }

можно фильтровать по id цветов размеров по значениям доп свойтств.