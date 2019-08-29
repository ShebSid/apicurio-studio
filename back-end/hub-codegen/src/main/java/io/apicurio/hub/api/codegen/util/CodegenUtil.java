/*
 * Copyright 2018 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.hub.api.codegen.util;

import io.apicurio.datamodels.core.models.Extension;
import io.apicurio.datamodels.openapi.models.OasSchema;

public final class CodegenUtil {
    
    public static final String schemaToPackageName(OasSchema schema, String defaultPackage) {
        String pname = defaultPackage;
        
        if (schema != null) {
            // Handle x-codegen-package (custom package name for a generated bean)
            Extension extension = schema.getExtension("x-codegen-package");
            if (extension != null && extension.value != null) {
                String packageName = String.valueOf(extension.value);
                if (!packageName.trim().isEmpty()) {
                    pname = packageName;
                }
            }
        }

        return pname;
    }

}
