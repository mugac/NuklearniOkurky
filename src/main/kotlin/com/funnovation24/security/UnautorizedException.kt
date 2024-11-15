package com.funnovation24.security

class UnautorizedException : RuntimeException {
    constructor(message: String, ex: Exception?) : super(message, ex) {}
    constructor(message: String) : super(message) {}
    constructor(ex: Exception) : super(ex) {}
}