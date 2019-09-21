import React from 'react';
import { shallow } from 'enzyme';
import { LoginPage } from '../../../src/features/login/LoginPage';

describe('login/LoginPage', () => {
  it('renders node with correct class name', () => {
    const props = {
      login: {},
      actions: {},
    };
    const renderedComponent = shallow(
      <LoginPage {...props} />
    );

    expect(
      renderedComponent.find('.login-login-page').length
    ).toBe(1);
  });
});
