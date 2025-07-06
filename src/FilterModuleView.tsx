import { requireNativeView } from 'expo';
import * as React from 'react';

import { FilterModuleViewProps } from './FilterModule.types';

const NativeView: React.ComponentType<FilterModuleViewProps> =
  requireNativeView('FilterModule');

export default function FilterModuleView(props: FilterModuleViewProps) {
  return <NativeView {...props} />;
}
