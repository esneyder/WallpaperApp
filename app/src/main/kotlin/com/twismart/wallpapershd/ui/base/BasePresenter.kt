/*
 * Copyright (C) 2017 Sneyder Angulo.
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

package com.twismart.wallpapershd.ui.base

import com.twismart.wallpapershd.data.IDataManager
import com.twismart.wallpapershd.utils.debug

import javax.inject.Inject

import io.reactivex.disposables.CompositeDisposable


open class BasePresenter<V : BaseContract.View>
@Inject constructor(val dataManager: IDataManager, val compositeDisposable: CompositeDisposable) : BaseContract.Presenter<V> {

    var baseView: V? = null

    override fun attachView(view: V) {
        baseView = view
        debug("presenter attachView")
    }

    override fun detachView() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
        baseView = null
        debug("presenter detachView")
    }

    val isViewAttached: Boolean get() = baseView != null
}
