/**
 * Copyright 2016 Hortonworks.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package com.hortonworks.registries.schemaregistry.serde;

import com.hortonworks.registries.schemaregistry.Resourceable;

/**
 * Serializer interface for serializing input {@code I} into output {@code O} according to the Schema {@code S}.
 * <p>Common way to use this serializer implementation is like below. </p>
 * <pre>{@code
 *     SnapshotSerializer serializer = ...
 *     // initialize with given configuration
 *     serializer.init(config);
 *
 *     // this instance can be used for multiple serialization invocations
 *     serializer.serialize(input, schema);
 *
 *     // close it to release any resources held
 *     serializer.close();
 * }</pre>
 * @param <I> Input type of the payload
 * @param <O> serialized output type. For ex: byte[], String etc.
 * @param <S> schema related information, which can be used for Input to be serialized as Output
 */
public interface SnapshotSerializer<I, O, S> extends Resourceable {

    /**
     * @param input input payload
     * @param schema schema
     *
     * @return an instance of O which is serialized input according to the given schema
     */
    O serialize(I input, S schema) throws SerDesException;

}
