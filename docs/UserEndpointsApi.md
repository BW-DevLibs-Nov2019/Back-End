# UserEndpointsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewUserUsingPOST1**](UserEndpointsApi.md#addNewUserUsingPOST1) | **POST** /users/user | adds a user given in the request body
[**deleteUserByIdUsingDELETE**](UserEndpointsApi.md#deleteUserByIdUsingDELETE) | **DELETE** /users/user/{id} | deleteUserById
[**deleteUserRoleByIdsUsingDELETE**](UserEndpointsApi.md#deleteUserRoleByIdsUsingDELETE) | **DELETE** /users/user/{userid}/role/{roleid} | deleteUserRoleByIds
[**getCurrentUserInfoUsingGET**](UserEndpointsApi.md#getCurrentUserInfoUsingGET) | **GET** /users/getuserinfo | getCurrentUserInfo
[**getCurrentUserNameUsingGET**](UserEndpointsApi.md#getCurrentUserNameUsingGET) | **GET** /users/getusername | getCurrentUserName
[**getNumUserEmailsUsingGET**](UserEndpointsApi.md#getNumUserEmailsUsingGET) | **GET** /users/user/email/count | getNumUserEmails
[**getUserByIdUsingGET**](UserEndpointsApi.md#getUserByIdUsingGET) | **GET** /users/user/{userId} | Retrieve a user based of off user id
[**getUserByNameUsingGET**](UserEndpointsApi.md#getUserByNameUsingGET) | **GET** /users/user/name/{userName} | returns the user based off of user name
[**getUserLikeNameUsingGET**](UserEndpointsApi.md#getUserLikeNameUsingGET) | **GET** /users/user/name/like/{userName} | returns all Users whose name contains the given substring with paging and sorting
[**listAllUsersUsingGET**](UserEndpointsApi.md#listAllUsersUsingGET) | **GET** /users/users | returns all Users with paging and sorting
[**postUserRoleByIdsUsingPOST**](UserEndpointsApi.md#postUserRoleByIdsUsingPOST) | **POST** /users/user/{userid}/role/{roleid} | postUserRoleByIds
[**reallyListAllUsersUsingGET**](UserEndpointsApi.md#reallyListAllUsersUsingGET) | **GET** /users/allusers | returns all Users without paging or sorting
[**updateUserUsingPUT**](UserEndpointsApi.md#updateUserUsingPUT) | **PUT** /users/user/{id} | updateUser


## **addNewUserUsingPOST1**

adds a user given in the request body

### Example
```bash
 addNewUserUsingPOST1
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newuser** | [**User**](User.md) | newuser |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteUserByIdUsingDELETE**

deleteUserById

### Example
```bash
 deleteUserByIdUsingDELETE id=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** | id |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteUserRoleByIdsUsingDELETE**

deleteUserRoleByIds

### Example
```bash
 deleteUserRoleByIdsUsingDELETE roleid=value userid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleid** | **integer** | roleid |
 **userid** | **integer** | userid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getCurrentUserInfoUsingGET**

getCurrentUserInfo

### Example
```bash
 getCurrentUserInfoUsingGET  authenticated=value  authorities[0].authority=value  Specify as:   Specify as:   Specify as: 
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authenticated** | **boolean** |  | [optional]
 **authorities[0].authority** | **string** |  | [optional]
 **credentials** | [**map[String, string]**](string.md) |  | [optional]
 **details** | [**map[String, string]**](string.md) |  | [optional]
 **principal** | [**map[String, string]**](string.md) |  | [optional]

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getCurrentUserNameUsingGET**

getCurrentUserName

### Example
```bash
 getCurrentUserNameUsingGET  authenticated=value  authorities[0].authority=value  Specify as:   Specify as:   Specify as: 
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authenticated** | **boolean** |  | [optional]
 **authorities[0].authority** | **string** |  | [optional]
 **credentials** | [**map[String, string]**](string.md) |  | [optional]
 **details** | [**map[String, string]**](string.md) |  | [optional]
 **principal** | [**map[String, string]**](string.md) |  | [optional]

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getNumUserEmailsUsingGET**

getNumUserEmails

### Example
```bash
 getNumUserEmailsUsingGET
```

### Parameters
This endpoint does not need any parameter.

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getUserByIdUsingGET**

Retrieve a user based of off user id

### Example
```bash
 getUserByIdUsingGET userId=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **integer** | User id |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getUserByNameUsingGET**

returns the user based off of user name

### Example
```bash
 getUserByNameUsingGET userName=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userName** | **string** | Username |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getUserLikeNameUsingGET**

returns all Users whose name contains the given substring with paging and sorting

### Example
```bash
 getUserLikeNameUsingGET userName=value  page=value  size=value  Specify as:  sort=value1 sort=value2 sort=...
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userName** | **string** | Username |
 **page** | [**Object**](.md) | Results page you want to retrieve (1..N) | [optional]
 **size** | [**Object**](.md) | Number of records per page. | [optional]
 **sort** | [**array[string]**](string.md) | Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported. | [optional]

### Return type

[**array[User]**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listAllUsersUsingGET**

returns all Users with paging and sorting

### Example
```bash
 listAllUsersUsingGET  page=value  size=value  Specify as:  sort=value1 sort=value2 sort=...
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | [**Object**](.md) | Results page you want to retrieve (1..N) | [optional]
 **size** | [**Object**](.md) | Number of records per page. | [optional]
 **sort** | [**array[string]**](string.md) | Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported. | [optional]

### Return type

[**array[User]**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **postUserRoleByIdsUsingPOST**

postUserRoleByIds

### Example
```bash
 postUserRoleByIdsUsingPOST roleid=value userid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleid** | **integer** | roleid |
 **userid** | **integer** | userid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **reallyListAllUsersUsingGET**

returns all Users without paging or sorting

### Example
```bash
 reallyListAllUsersUsingGET
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**array[User]**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **updateUserUsingPUT**

updateUser

### Example
```bash
 updateUserUsingPUT id=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** | id |
 **updateUser** | [**User**](User.md) | updateUser |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

