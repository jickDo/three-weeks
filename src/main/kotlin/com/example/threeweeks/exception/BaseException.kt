package com.example.threeweeks.exception


class BaseException(val baseResponseCode: BaseResponseCode): RuntimeException() {
}
