// Rekit uses a new approach to organizing actions and reducers. That is
// putting related actions and reducers in one file. See more at:
// https://medium.com/@nate_wang/a-new-approach-for-managing-redux-actions-91c26ce8b5da

import {
    NAV_HEADER_TOGGLE_HEADER,
} from './constants';

export function toggleHeader() {
    return {
        type: NAV_HEADER_TOGGLE_HEADER,
    };
}

export function reducer(state, action) {
    switch (action.type) {
        case NAV_HEADER_TOGGLE_HEADER:
            return {
                ...state,
                headerToggled: !state.headerToggled,
            };

        default:
            return state;
    }
}
