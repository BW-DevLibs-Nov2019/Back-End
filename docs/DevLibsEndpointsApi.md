# DevLibsEndpointsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewDevLibAnswersUsingPOST**](DevLibsEndpointsApi.md#addNewDevLibAnswersUsingPOST) | **POST** /devlibs/devlib/answers/{devlibid} | Finds Answers By DevLib ID
[**addNewDevLibUsingPOST**](DevLibsEndpointsApi.md#addNewDevLibUsingPOST) | **POST** /devlibs/create | Adds New DevLib
[**deleteDevLibByIdUsingDELETE**](DevLibsEndpointsApi.md#deleteDevLibByIdUsingDELETE) | **DELETE** /devlibs/devlib/{devlibid} | Deletes DevLib By Id
[**findAnswersByDevLibIdUsingGET**](DevLibsEndpointsApi.md#findAnswersByDevLibIdUsingGET) | **GET** /devlibs/devlib/answers/{devlibid} | Finds Answers By DevLib ID
[**findDevLibsByUserNameUsingGET**](DevLibsEndpointsApi.md#findDevLibsByUserNameUsingGET) | **GET** /devlibs/devlib/{username} | Finds all DevLibs by username
[**listAllDevLibsUsingGET**](DevLibsEndpointsApi.md#listAllDevLibsUsingGET) | **GET** /devlibs/alldevlibsforuser | returns all DevLibs
[**updateDevLibUsingPUT**](DevLibsEndpointsApi.md#updateDevLibUsingPUT) | **PUT** /devlibs/devlib/{devlibid} | Updates DevLib


## **addNewDevLibAnswersUsingPOST**

Finds Answers By DevLib ID

### Example
```bash
 addNewDevLibAnswersUsingPOST devlibid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **answers** | [**Answer**](Answer.md) | answers |
 **devlibid** | **integer** | devlibid |

### Return type

[**DevLib**](DevLib.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **addNewDevLibUsingPOST**

Adds New DevLib

### Example
```bash
 addNewDevLibUsingPOST  authenticated=value  authorities[0].authority=value  Specify as:   Specify as:   Specify as: 
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newDevLib** | [**DevLib**](DevLib.md) | newDevLib |
 **authenticated** | **boolean** |  | [optional]
 **authorities[0].authority** | **string** |  | [optional]
 **credentials** | [**map[String, string]**](string.md) |  | [optional]
 **details** | [**map[String, string]**](string.md) |  | [optional]
 **principal** | [**map[String, string]**](string.md) |  | [optional]

### Return type

[**DevLib**](DevLib.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteDevLibByIdUsingDELETE**

Deletes DevLib By Id

### Example
```bash
 deleteDevLibByIdUsingDELETE devlibid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **devlibid** | **integer** | Dev Lib Id |

### Return type

[**DevLib**](DevLib.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **findAnswersByDevLibIdUsingGET**

Finds Answers By DevLib ID

### Example
```bash
 findAnswersByDevLibIdUsingGET devlibid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **devlibid** | **integer** | Dev Lib Id |

### Return type

[**DevLib**](DevLib.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **findDevLibsByUserNameUsingGET**

Finds all DevLibs by username

### Example
```bash
 findDevLibsByUserNameUsingGET username=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **string** | User Name |

### Return type

[**DevLib**](DevLib.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listAllDevLibsUsingGET**

returns all DevLibs

### Example
```bash
 listAllDevLibsUsingGET  authenticated=value  authorities[0].authority=value  Specify as:   Specify as:   Specify as: 
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

[**array[DevLib]**](DevLib.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **updateDevLibUsingPUT**

Updates DevLib

### Example
```bash
 updateDevLibUsingPUT devlibid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **devlibid** | **integer** | Dev Lib Id |
 **updateDevLib** | [**DevLib**](DevLib.md) | updateDevLib |

### Return type

[**DevLib**](DevLib.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

