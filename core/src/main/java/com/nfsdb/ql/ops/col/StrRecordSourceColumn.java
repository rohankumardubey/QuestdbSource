/*******************************************************************************
 *  _  _ ___ ___     _ _
 * | \| | __/ __| __| | |__
 * | .` | _|\__ \/ _` | '_ \
 * |_|\_|_| |___/\__,_|_.__/
 *
 * Copyright (c) 2014-2015. The NFSdb project and its contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.nfsdb.ql.ops.col;

import com.nfsdb.io.sink.CharSink;
import com.nfsdb.ql.Record;
import com.nfsdb.ql.StorageFacade;
import com.nfsdb.ql.ops.AbstractVirtualColumn;
import com.nfsdb.store.ColumnType;

public class StrRecordSourceColumn extends AbstractVirtualColumn {
    private final int index;

    public StrRecordSourceColumn(int index) {
        super(ColumnType.STRING);
        this.index = index;
    }

    @Override
    public CharSequence getFlyweightStr(Record rec) {
        return rec.getFlyweightStr(index);
    }

    @Override
    public CharSequence getStr(Record rec) {
        return rec.getStr(index);
    }

    @Override
    public void getStr(Record rec, CharSink sink) {
        rec.getStr(index, sink);
    }

    @Override
    public int getStrLen(Record rec) {
        return rec.getStrLen(index);
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public void prepare(StorageFacade facade) {
    }
}
