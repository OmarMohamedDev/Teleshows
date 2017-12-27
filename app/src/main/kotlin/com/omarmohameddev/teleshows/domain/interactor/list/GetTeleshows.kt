package com.omarmohameddev.teleshows.domain.interactor.list

import com.omarmohameddev.teleshows.domain.executor.PostExecutionThread
import com.omarmohameddev.teleshows.domain.executor.ThreadExecutor
import com.omarmohameddev.teleshows.domain.interactor.FlowableUseCase
import com.omarmohameddev.teleshows.domain.repository.TeleshowsRepository
import com.omarmohameddev.teleshows.model.Teleshow
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Teleshow] instances from the [TeleshowsRepository]
 */
open class GetTeleshows @Inject constructor(val teleshowsRepository: TeleshowsRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread):
        FlowableUseCase<List<Teleshow>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Flowable<List<Teleshow>> {
        return teleshowsRepository.getTeleshows()
    }
}

