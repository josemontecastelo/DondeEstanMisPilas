package com.josealfonsomora.dondeestanmispilas.bd

import android.provider.BaseColumns

object PilasDBScheme: BaseColumns {
    const val TABLE_NAME = "pilas"
    const val COLUMN_NAME = "name"
    const val COLUMN_DESCRIPTION = "description"
    const val COLUMN_TYPE = "type"
    const val COLUMN_LOCATION = "location"
}

const val SQL_CREATE_ENTRIES = """
    CREATE TABLE ${PilasDBScheme.TABLE_NAME} (
        ${PilasDBScheme.COLUMN_NAME} TEXT PRIMARY KEY,
        ${PilasDBScheme.COLUMN_DESCRIPTION} TEXT,
        ${PilasDBScheme.COLUMN_TYPE} TEXT,
        ${PilasDBScheme.COLUMN_LOCATION} TEXT
    )
"""

private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${PilasDBScheme.TABLE_NAME}"

