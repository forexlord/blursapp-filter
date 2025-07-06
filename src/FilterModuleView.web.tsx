import * as React from 'react';

import { FilterModuleViewProps } from './FilterModule.types';

export default function FilterModuleView(props: FilterModuleViewProps) {
  return (
    <div>
      <iframe
        style={{ flex: 1 }}
        src={props.url}
        onLoad={() => props.onLoad({ nativeEvent: { url: props.url } })}
      />
    </div>
  );
}
