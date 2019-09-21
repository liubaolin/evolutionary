import {
  NAV_HEADER_TOGGLE_HEADER,
} from '../../../../src/features/nav-header/redux/constants';

import {
  toggleHeader,
  reducer,
} from '../../../../src/features/nav-header/redux/toggleHeader';

describe('nav-header/redux/toggleHeader', () => {
  it('returns correct action by toggleHeader', () => {
    expect(toggleHeader()).toHaveProperty('type', NAV_HEADER_TOGGLE_HEADER);
  });

  it('handles action type NAV_HEADER_TOGGLE_HEADER correctly', () => {
    const prevState = {};
    const state = reducer(
      prevState,
      { type: NAV_HEADER_TOGGLE_HEADER }
    );
    // Should be immutable
    expect(state).not.toBe(prevState);

    // TODO: use real case expected value instead of {}.
    const expectedState = {};
    expect(state).toEqual(expectedState);
  });
});
