package com.gabrielfv.libraries.common.di

import javax.inject.Qualifier
import kotlin.annotation.AnnotationTarget.*

@Qualifier
@Target(FIELD, VALUE_PARAMETER, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER)
@Retention(AnnotationRetention.BINARY)
annotation class AsViewModel