/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.z.global.discovery;


import java.util.Collection;
import java.util.HashMap;

/**
 * An extension point allowing to plug in custom functionality.
 * <p/>
 * A plugin can be dynamically injected with {@link Module} by implementing <tt>onModule(AnyModule)</tt> method
 * removing the need to override {@link #processModule(org.elasticsearch.common.inject.Module)} and check using
 * instanceof.
 */
public interface Plugin {

    /**
     * The name of the plugin.
     */
    String name();

    /**
     * The description of the plugin.
     */
    String description();

    /**
     * Node level modules (classes, will automatically be created).
     */
    Collection<Class<? extends Module>> modules();

    /**
     * Node level modules (instances)
     *
     * @param settings The node level settings.
     */
    Collection<? extends Module> modules(HashMap<String,Object> settings);

    /**
     * Node level services that will be automatically started/stopped/closed.
     */

    /**
     * Per index modules.
     */
    Collection<Class<? extends Module>> indexModules();

    /**
     * Per index modules.
     */
    Collection<? extends Module> indexModules(HashMap<String,Object> settings);

    /**
     * Per index services that will be automatically closed.
     */

    /**
     * Per index shard module.
     */
    Collection<Class<? extends Module>> shardModules();

    /**
     * Per index shard module.
     */
    Collection<? extends Module> shardModules(HashMap<String,Object> settings);

    /**
     * Per index shard service that will be automatically closed.
     */

    /**
     * Process a specific module. Note, its simpler to implement a custom <tt>onModule(AnyModule module)</tt>
     * method, which will be automatically be called by the relevant type.
     */
    void processModule(Module module);

    /**
     * Additional node settings loaded by the plugin
     */
    HashMap<String,Object> additionalSettings();
}
