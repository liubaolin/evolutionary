import React from 'react';
import { shallow } from 'enzyme';
import { NavHeader } from '../../../src/features/nav-header/NavHeader';

describe('nav-header/NavHeader', () => {
  it('renders node with correct class name', () => {
    const props = {
      header: {},
      actions: {},
    };
    const renderedComponent = shallow(
      <NavHeader {...props} />
    );

    expect(
      renderedComponent.find('.nav-header-nav-header').length
    ).toBe(1);
  });
});
