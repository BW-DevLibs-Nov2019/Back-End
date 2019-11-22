# UseremailEndpointsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteUserEmailByIdUsingDELETE**](UseremailEndpointsApi.md#deleteUserEmailByIdUsingDELETE) | **DELETE** /useremails/useremail/{useremailid} | deleteUserEmailById
[**findUseremailByUserNameUsingGET**](UseremailEndpointsApi.md#findUseremailByUserNameUsingGET) | **GET** /useremails/username/{userName} | findUseremailByUserName
[**getUserEmailByIdUsingGET**](UseremailEndpointsApi.md#getUserEmailByIdUsingGET) | **GET** /useremails/useremail/{useremailId} | getUserEmailById
[**listAllUseremailsUsingGET**](UseremailEndpointsApi.md#listAllUseremailsUsingGET) | **GET** /useremails/useremails | listAllUseremails
[**updateUserEmailUsingPUT**](UseremailEndpointsApi.md#updateUserEmailUsingPUT) | **PUT** /useremails/useremail/{useremailid}/email/{emailaddress} | updateUserEmail


## **deleteUserEmailByIdUsingDELETE**

deleteUserEmailById

### Example
```bash
 deleteUserEmailByIdUsingDELETE useremailid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **useremailid** | **integer** | useremailid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **findUseremailByUserNameUsingGET**

findUseremailByUserName

### Example
```bash
 findUseremailByUserNameUsingGET userName=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userName** | **string** | userName |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getUserEmailByIdUsingGET**

getUserEmailById

### Example
```bash
 getUserEmailByIdUsingGET useremailId=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **useremailId** | **integer** | useremailId |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listAllUseremailsUsingGET**

listAllUseremails

### Example
```bash
 listAllUseremailsUsingGET
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

## **updateUserEmailUsingPUT**

updateUserEmail

### Example
```bash
 updateUserEmailUsingPUT emailaddress=value useremailid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **emailaddress** | **string** | emailaddress |
 **useremailid** | **integer** | useremailid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

