/*
Copyright 2013 Daniel Manzke (devsurf)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package de.devsurf.security.otp.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public enum Hash {

    MD4( "MD4" ), MD5( "MD5" ), SHA1( "SHA1" ), SHA256( "SHA256" ), SHA512( "SHA512" );

    private String hash;

    Hash( String hash ) {
        this.hash = hash;
    }

    public byte[] digest( byte[] challenge )
        throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance( this.toString() );
        return digest.digest( challenge );
    }

    @Override
    public String toString() {
        return hash;
    }
}
