/*
 * MockedFDBDirectoryWrapper.java
 *
 * This source file is part of the FoundationDB open source project
 *
 * Copyright 2015-2024 Apple Inc. and the FoundationDB project authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.apple.foundationdb.record.lucene.directory;

import com.apple.foundationdb.record.provider.foundationdb.IndexMaintainerState;
import com.apple.foundationdb.subspace.Subspace;
import com.apple.foundationdb.tuple.Tuple;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * A Testing-focused {@link FDBDirectoryWrapper} that allows a mocked-FDBDirectory to be injected into the system.
 */
public class MockedFDBDirectoryWrapper extends FDBDirectoryWrapper {
    MockedFDBDirectoryWrapper(final IndexMaintainerState state, final Tuple key, final int mergeDirectoryCount, final AgilityContext agilityContext, final int blockCacheMaximumSize) {
        super(state, key, mergeDirectoryCount, agilityContext, blockCacheMaximumSize);
    }

    @Nonnull
    @Override
    protected FDBDirectory createFDBDirectory(final Subspace subspace, final Map<String, String> options, final FDBDirectorySharedCacheManager sharedCacheManager, final Tuple sharedCacheKey, final boolean useCompoundFile, final AgilityContext agilityContext, final int blockCacheMaximumSize) {
        return new MockedFDBDirectory(subspace, options, sharedCacheManager, sharedCacheKey, useCompoundFile, agilityContext, blockCacheMaximumSize);
    }
}